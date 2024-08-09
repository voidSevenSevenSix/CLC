import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLC {
    /* Default completion state */
    public Boolean[][] defaultCompletionStates = new Boolean[16][16];
    /* Map times */
    public int[][] timetable = new int[16][16];
    /* Map keys */
    public ArrayList<String> keys = new ArrayList<String>(Arrays.asList("Linden", "Howard", "Skokie", "63rd", "95th", "GLSS", "Harlem", "Forest Park", "Ohare", "Jefferson Park", "Kimball", "Loop", "Midway", "54th", "Garfield"));
    /* Best route globals */
    private int currentBestRouteTimeMin = 700;
    private String currentBestRoute = "";

    public CLC(){
        System.out.println("[CLC]: Chicago L Challenge Calculator - Object Initialized");
        System.out.println("[CLC]: Initializing default completion states, busses, and timetables...");
        setConnections("Howard", Arrays.asList("Linden", "Skokie", "Loop"), Arrays.asList(15, 10, 30));
        setConnections("63rd", Arrays.asList("95th", "Loop", "GLSS", "Midway"), Arrays.asList(15, 20, 15, 30));
        setConnections("Garfield", Arrays.asList("GLSS", "Loop"), Arrays.asList(15, 30));
        setConnections("Midway", Arrays.asList("54th", "Loop", "GLSS"), Arrays.asList(20, 30, 35));
        setConnections("54th", Arrays.asList("Loop"), Arrays.asList(30));
        setConnections("Harlem", Arrays.asList("Loop", "Forest Park"), Arrays.asList(30, 15));
        setConnections("Forest Park", Arrays.asList("Ohare"), Arrays.asList(60));
        setConnections("Jefferson Park", Arrays.asList("Ohare", "Kimball"), Arrays.asList(20, 20));
        setConnections("Kimball", Arrays.asList("Loop"), Arrays.asList(30));
        setBusConnections("Midway", Arrays.asList("54th", "GLSS", "63rd"));
        setBusConnections("GLSS", Arrays.asList("63rd"));
        setBusConnections("Forest Park", Arrays.asList("Harlem"));
        setBusConnections("Jefferson Park", Arrays.asList("Kimball"));
        System.out.println("[CLC]: Ready for analysis.");
    }

    public void prepAndAnalyzeFromStation(String startStation){
        System.out.println("[CLC]: Initiating analysis...");
        SMap defaultCompletionStateMap = new SMap(defaultCompletionStates);
        analyze(defaultCompletionStateMap, startStation, 0, startStation, 0, "null");
        System.out.println("[CLC]: Analysis completed.");
        System.out.println("[CLC]: Analysis determined that the best route takes approximately " + (double)currentBestRouteTimeMin/60 + " hours.");
        System.out.println("[CLC]: " + currentBestRoute);
    }

    private void analyze(SMap map, String currentStation, int stepsSinceLastFalse, String route, int duration, String lastStation){
        if(duration > currentBestRouteTimeMin){
            return;
        }
        //System.out.println("[CLC-Debug]: This is " + currentStation);
        if(duration < currentBestRouteTimeMin && isComplete(map)){
            currentBestRouteTimeMin = duration;
            currentBestRoute = route;
        }
        int currentStationIndex = keys.indexOf(currentStation);
        int numIncomplete = 0;
        for(int i = 0; i < map.completionMap.length; i++){
            if(map.completionMap[currentStationIndex][i] == null){
                continue;
            }
            if(!map.completionMap[currentStationIndex][i]){
                numIncomplete++;
            }
        }
        if(numIncomplete > 0){
            for(int i = 0; i < map.completionMap.length; i++){
                if(map.completionMap[currentStationIndex][i] == null){
                    continue;
                }
                if(!map.completionMap[currentStationIndex][i]){
                    SMap newMap = new SMap(map.completionMap);
                    setBooleanSym(newMap.completionMap, i, currentStationIndex, true);
                    if(keys.get(i).equals(lastStation) && numIncomplete != 1){
                        continue;
                    }
                    analyze(newMap, keys.get(i), 0, route + "->" + keys.get(i), duration + timetable[currentStationIndex][i] + 8, currentStation);
                }
            }
        }
        if(stepsSinceLastFalse < 2){
            for(int i = 0; i < map.completionMap.length; i++){
                if(map.completionMap[currentStationIndex][i] != null){
                    SMap newMap = new SMap(map.completionMap);
                    setBooleanSym(newMap.completionMap, i, currentStationIndex, true);
                    analyze(newMap, keys.get(i), stepsSinceLastFalse+1, route + "->" + keys.get(i), duration + timetable[currentStationIndex][i] + 8, currentStation);
                }
            }
        }
    }

    private boolean isComplete(SMap map){
        int falses = 0;
        String locs = "";
        for(int i = 0; i < map.completionMap.length; i++){
            for(int j = 0; j < map.completionMap.length; j++){
                if(map.completionMap[i][j] == null){
                    continue;
                }
                if(!map.completionMap[i][j]){
                    //falses++;
                    //locs += keys.get(i) + " to " + keys.get(j) + ",";
                    return false;
                }
            }
        }
        //if(falses < 4){
            //System.out.println("[CLC-Debug]: Falses at " + falses);
            //System.out.println("[CLC-Debug]: Found at: " + locs);
        //}   
        //return falses==0;
        return true;
    }

    /* Array has to be symmetrical across y=-x, but both sides will be updated symmetrically. Allows for travel to happen in both directions. */
    private void setBooleanSym(Boolean[][] arr, int i, int j, boolean b){
        arr[i][j] = b;
        arr[j][i] = b;
    }

    private void setIntSym(int[][] arr, int i, int j, int v){
        arr[i][j] = v;
        arr[j][i] = v;
    }

    private void setConnections(String mainStation, List<String> connections, List<Integer> min){
        int mainStationIndex = keys.indexOf(mainStation);
        int minI = 0;
        for(String connection : connections){
            setBooleanSym(defaultCompletionStates, mainStationIndex, keys.indexOf(connection), false);
            setIntSym(timetable, mainStationIndex, keys.indexOf(connection), min.get(minI));
            minI++;
        }
    }

    private void setBusConnections(String mainStation, List<String> connections){
        int mainStationIndex = keys.indexOf(mainStation);
        for(String connection : connections){
            setBooleanSym(defaultCompletionStates, mainStationIndex, keys.indexOf(connection), true);
        }
    }

    public static void main(String[] args){
        System.out.println("Initializing...");
        CLC clc = new CLC();
        clc.prepAndAnalyzeFromStation("Linden");
        System.out.println("Complete.");
    }
}
