class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0;
        int start = 0;
        
        // If the total (gas - cost) across the entire route is < 0, then we know there's no possible route.
        int routeGas = 0;
        
        for (int i = 0; i < gas.length; i++) {
            final int delta = gas[i] - cost[i];
            gasInTank += delta;
            routeGas += delta;
            
            // No gas to get to the next station, means we must be starting from the next station
            if (gasInTank < 0) {
                gasInTank = 0;
                start = i + 1;
            }
        }
        
        return routeGas >= 0 ? start : -1;
    }
}