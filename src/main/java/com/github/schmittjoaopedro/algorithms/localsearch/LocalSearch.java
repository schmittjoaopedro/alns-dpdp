package com.github.schmittjoaopedro.algorithms.localsearch;

import com.github.schmittjoaopedro.problem.Instance;
import com.github.schmittjoaopedro.problem.Solution;
import com.github.schmittjoaopedro.problem.SolutionUtils;

public class LocalSearch {

    private RelocateRequests relocateRequests;

    private ExchangeRequests exchangeRequests;

    public LocalSearch(Instance instance) {
        relocateRequests = new RelocateRequests(instance);
        exchangeRequests = new ExchangeRequests(instance);
    }

    public Solution applyImprovement(Solution solution) {
        boolean improvement = true;
        Solution improved = SolutionUtils.copy(solution);
        Solution tempSolution = improved;
        while (improvement) {
            improvement = false;
            tempSolution = relocateRequests.relocate(tempSolution);
            tempSolution = exchangeRequests.exchange(tempSolution);
            if (SolutionUtils.getBest(improved, tempSolution) == tempSolution) {
                improved = SolutionUtils.copy(tempSolution);
                improvement = true;
            }
        }
        return improved;
    }
}
