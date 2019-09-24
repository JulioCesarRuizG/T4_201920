package model.data_structures;

public class TravelTime implements Comparable<TravelTime>{

	private double meanTravelTime;
	
	public double darTravelTime()
	{
		return meanTravelTime;
	}

@Override
public int compareTo(TravelTime t) {
	if(meanTravelTime > t.darTravelTime())
	{
		return 1;
	}
	else if(meanTravelTime < t.darTravelTime())
	{
		return -1;
	}
	return 0;
}
}