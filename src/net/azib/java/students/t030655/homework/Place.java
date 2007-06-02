package net.azib.java.students.t030655.homework;

import java.util.PriorityQueue;

/**
 * Place - Class to add places to the competitors. 
 *
 * @author Triin Nestor
 */
public class Place {
	
	/**
	 * Method takes in PriorityQueue of competitors, compares points of competitors, adds places
	 * to each and gives out PriorityQueue, where competitors have places. 
	 * 
	 * @param competitorsQueue - PriorityQueue of competitors
	 * @return PriorityQueue of competitors with places
	 */
	public PriorityQueue<Competitor> competitionResults (PriorityQueue<Competitor> competitorsQueue){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(competitorsQueue);
		int l = compQueue.size();	//number of competitors in PriorityQueue
		int[] masPoints = new int[l];	//array for points
		String[] masPlaces = new String[l];	//array for places
		Competitor competitor = null;
		int m = 0;	//iterator
		//competitors' points to array of points
		while ((competitor = compQueue.poll())!= null){
			masPoints[m] = competitor.getTotalPoints();
			m++;
		}
		//scanning points to find place-sharing
		int j=0;
		int count=0;
		int k =0;
		for (int i = 0; i < l; ){
			j = i + 1;	//i and j are iterators
			count = 0;	//counter to count the number of same points
			//counting the number of same points
			while ((j<l) && (masPoints[i] == masPoints[j])){
				count++;
				j++;
			}
			k = i;
			//inserting correct places to masPlaces
			if (k == (j-1)){
				masPlaces[k] =(i + 1) + ". ";
			}
			else{
				for ( ; k<j; k++){
					masPlaces[k] = (i + 1) + "-" + (i + 1 + count) + ". ";
				}
			}
			if (count == 0){
				i= i + 1;
			}
			else{
				i = i + 1 + count;
			}
			
		}
		//inserting places into competitors and making new PriorityQueue 
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>(competitorsQueue);
		PriorityQueue<Competitor> placeQueue = new PriorityQueue<Competitor>();
		Competitor comp = null;
		int p = 0;
		while ((comp = pq.poll())!= null){
			comp.setPlace(masPlaces[p]);
			placeQueue.add(comp);
			p++;
		}
		return placeQueue;
	}

}
