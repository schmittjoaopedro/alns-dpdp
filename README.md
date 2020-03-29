# Adaptive Large Neighborhood Search for Dynamic Pick-up and Delivery Problem

An proposal of Adaptive Large Neighborhood Search Algorithm for the Pickup and Delivery Problem with Time Windows and Dynamic Requests (DPDPTW). 

## Overview

The VRP is a broad study field, usually tackled as part of transport management systems (TMS). Nowadays, the last-mile model has been received a lot of attention in the TMS systems, mainly because of its focus on the delivery of products directly to the final client. Besides that, in this model clients can make a call at any time requesting a pickup or delivery on the same day, without previous notification. This kind of request is known as dynamic request. In the literature, the last-mile model can be framed as the pickup and delivery problem with time windows and dynamic requests (DPDPTW). The DPDPTW is an extension of the PDPTW where the dynamic requests are considered. The PDPTW problem has received considerable attention on the literature, differently from the DPDPTW that has not received much attention yet. The development of solutions to VRP problems is not a trivial task because it has to deal with a combinatorial explosion of calculations to find a suitable solution for the problem. Studies highlight the advantages of the adaptive large neighborhood search (ALNS) method to deal with such combinatorial problems. Therefore, the research question addressed in the study is: is it possible to apply the ALNS to solve the DPDPTW problem, minimizing the number of vehicles and the total cost of the solution? Based on this assumption, this study proposes the development of a model based on ALNS to solve the DPDPTW, named here as ALNS-DPDP. To validate the proposed model, two benchmarks were executed, the first one applied to the PDPTW and the second one applied to the DPDPTW. In the first analysis, related to the static scenario (PDPTW), the results found indicate that the proposed method has a deviation of 2.27% in the number of vehicles and -2.36% of the total cost related to the best-known solutions from the literature. It allows us to conclude that the ALNS-DPDP is competitive with the literature because in that there is no one algorithm that found all the best solutions. In the second analysis, related to the dynamic scenario (DPDPTW), the results indicate that the number of vehicles increases by up to 108% and the total cost up to 72% when the dynamic degree is increased. This result is mainly impacted by the increment of the urgency factor of dynamic requests. Besides that, the results allowed us to identify limitations related to the long term optimization of the route, because when dynamic requests are announced the vehicles tend to take big deviations to attend the new client. Finally, this work also contributes by constructing a benchmark that can be used to develop methods applied to the DPDPTW problem.

## ALNS-DPDP Algorithm

The source code related to the ALNS-DPDP algorithm is available in the src/main/java directory. 
This software was developed using Maven and Java. Therefore, to execute the program, first we have to build the executable using the following command:

>  mvn clean install

This command will execute all tests to check that the algorithm is stable, and after that will create an executable `alns-dpdp.jar` file in the target folder.

To execute tests over static scenarios use the following command:

> java -Xmx4g -Xms2g -jar alns-dpdp-1.0.0-jar-with-dependencies.jar -numCpu 6 -numTrials 30 -maxIterations 25000 -localSearch -inputDir C:\Temp\input -outputDir C:\Temp\output

To execute tests over dynamic scenarios use the following command:

> java -Xmx4g -Xms2g -jar alns-dpdp-1.0.0-jar-with-dependencies.jar -numCpu 6 -numTrials 30 -maxIterations 25000 -movingVehicle -localSearch -inputDir C:\Temp\input -outputDir C:\Temp\output

A description about the available program parameters is presented following:

| Parameter | Description |
| --------- | ----------- |
| -numCpu | Define the number of CPUs available to run in parallel |
| -numTrials | Define the number of run for each test instance |
| -maxIterations | Define the solver maximum number of iterations |
| -movingVehicle | Activate the online optimization scenario | 
| -localSearch | Activate the use of local search algorithms |
| -inputDir | Define the directory to load from the tests instances |
| -outputDir | Define the directory to write the statistics results files |

For each run the following statistic results files will be generated

* \<instance name\>_bsf.csv: Holds the best solution result among all trials.
* \<instance name\>_summary.csv: Holds the mean solution results of all trials.
* \<instance name\>_iteration.csv: Holds mean statistic results for each iteration of algorithm. 

## DPDPTW Benchmark

The study benchmark data about DPDPTW is available in the following directories:

* [100-tasks](src/main/resources/dpdptw/100-tasks)
* [200-tasks](src/main/resources/dpdptw/200-tasks)
* [400-tasks](src/main/resources/dpdptw/400-tasks)
* [600-tasks](src/main/resources/dpdptw/600-tasks)
* [800-tasks](src/main/resources/dpdptw/800-tasks)
* [1000-tasks](src/main/resources/dpdptw/1000-tasks)

The study results for comparison is available in the following document: [ALNS-DPDP for DPDPTW](Masters%20Thesis%20-%20João%20Pedro%20Schmitt%20-%20Final.pdf)