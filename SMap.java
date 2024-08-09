public class SMap {
    public Boolean[][] completionMap = new Boolean[19][19];

    public SMap(Boolean[][] completedMap){
        for(int i = 0; i < completedMap.length; i++){
            for(int j = 0; j < completedMap.length; j++){
                this.completionMap[i][j] = completedMap[i][j];
            }
        }
    }
}
