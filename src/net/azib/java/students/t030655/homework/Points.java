package net.azib.java.students.t030655.homework;

/**
 * Points - This class saves points for every event and calculates total points
 *
 * @author Triin Nestor
 */
public class Points {
	int sprint100m;
	int longJump;
	int shotPut;
	int highJump;
	int sprint400m;
	int hurdles110m;
	int discusThrow;
	int poleVault;
	int javelinThrow;
	int race1500m;
	int totalPoints;
	
	/**Sets 100m sprint points
	 * 
	 * @param performance - event result in seconds
	 */
	public void setSprint100m (double performance){
		sprint100m = (int) Decathlon.SPRINT_100M.points(performance);
	}
	
//	public double getSprint100m(){
//		return sprint100m;
//	}
	
	/**Sets long jump points
	 * 
	 * @param performance - event result in meters
	 */
	public void setLongJump (double performance){
		longJump = (int) Decathlon.LONG_JUMP.points(performance);
	}
	
	/**Sets shot put points
	 * 
	 * @param performance - event result in meters
	 */
	public void setShotPut (double performance){
		shotPut = (int) Decathlon.SHOT_PUT.points(performance);
	}
	
	/**Sets high jump points
	 * 
	 * @param performance - event result in meters
	 */
	public void setHighJump (double performance){
		highJump = (int) Decathlon.HIGH_JUMP.points(performance);
	}
	
	/**Sets 400m sprint points
	 * 
	 * @param performance - event result in seconds
	 */
	public void setSprint400m (double performance){
		sprint400m = (int) Decathlon.SPRINT_400M.points(performance);
	}
	
	/**Sets 110m hurdles points
	 * 
	 * @param performance - event result in seconds
	 */
	public void setHurdles110m (double performance){
		hurdles110m = (int) Decathlon.HURDLES_110M.points(performance);
	}
	
	/**Sets discus throw points
	 * 
	 * @param performance - event result in meters
	 */
	public void setDiscusThrow (double performance){
		discusThrow = (int) Decathlon.DISCUS_THROW.points(performance);
	}
	
	/**Sets pole vault points
	 * 
	 * @param performance - event result in meters
	 */
	public void setPoleVault (double performance){
		poleVault = (int) Decathlon.POLE_VAULT.points(performance);
	}
	
	/**Sets javelin throw points
	 * 
	 * @param performance - event result in meters
	 */
	public void setJavelinThrow (double performance){
		javelinThrow = (int) Decathlon.JAVELIN_THROW.points(performance);
	}
	
	/**Sets 1500m race points
	 * 
	 * @param performance - event result in seconds
	 */
	public void setRace1500m (double performance){
		race1500m = (int) Decathlon.RACE_1500M.points(performance);
	}
	
	/**Calculates total points
	 * 
	 * @return totalPoints - total points according to the points of events
	 */
	public int totalPoints (){
		totalPoints = (int) (sprint100m + longJump + shotPut + highJump + sprint400m 
		+ hurdles110m + discusThrow + poleVault + javelinThrow + race1500m) ;
		return totalPoints;
	}
	
}
