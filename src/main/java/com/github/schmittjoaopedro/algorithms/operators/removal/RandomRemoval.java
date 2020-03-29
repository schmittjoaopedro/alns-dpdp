package com.github.schmittjoaopedro.algorithms.operators.removal;

import com.github.schmittjoaopedro.algorithms.RemovalOperator;
import com.github.schmittjoaopedro.problem.Instance;
import com.github.schmittjoaopedro.problem.Solution;
import com.github.schmittjoaopedro.problem.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomRemoval extends RemovalOperator {

    private Instance instance;

    private Random random;

    public RandomRemoval(Instance instance, Random random) {
        this.instance = instance;
        this.random = random;
    }

    @Override
    public void remove(Solution solution, int q) {
        List<Integer> requestIds = new ArrayList<>();
        for (Task pickupTask : instance.pickupTasks) {
            if (!solution.removedRequests[pickupTask.requestId]) {
                requestIds.add(pickupTask.requestId);
            }
        }
        Collections.shuffle(requestIds, random);
        if (requestIds.size() > q) requestIds = requestIds.subList(0, q);
        solution.remove(requestIds, instance);
    }
}
