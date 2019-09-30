package 笔试题;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-09-29 19:40
 * motto : everything is no in vain
 * description
 */
public class DuXiaoManTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNum = scanner.nextInt();
        int bridgeWeight = scanner.nextInt();
        int[] carWeights = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            carWeights[i] = scanner.nextInt();
        }
        int[] passTimes = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            passTimes[i] = scanner.nextInt();
        }
        int sumTime = 0;
        for (int time : passTimes) {
            sumTime += time;
        }
        int realTime = 0;
        int currentIndex = 0;
        List<Integer> onBridgeIndex = new LinkedList<>();
        while (bridgeWeight - carWeights[currentIndex] >= 0) {
            onBridgeIndex.add(currentIndex);
            bridgeWeight -= carWeights[currentIndex];
            currentIndex++;
        }
        for (realTime = 1; realTime < sumTime; realTime++) {
            List<Integer> removeIndex = new ArrayList<>();
            for (Integer index : onBridgeIndex) {
                passTimes[index]--;
                if (passTimes[index] == 0) {
                    //证明这辆车已经下去了
                    removeIndex.add(index);
                    bridgeWeight += carWeights[index];
                }
            }
            for (Integer index : removeIndex) {
                onBridgeIndex.remove(index);
            }
            while (currentIndex < carWeights.length && bridgeWeight - carWeights[currentIndex] >= 0) {
                onBridgeIndex.add(currentIndex);
                bridgeWeight -= carWeights[currentIndex];
                currentIndex++;
            }
            if (onBridgeIndex.size() == 0){
                break;
            }
        }
        System.out.println(realTime);
    }
}
