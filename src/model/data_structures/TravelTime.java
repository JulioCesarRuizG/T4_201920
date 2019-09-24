package model.data_structures;

public class TravelTime implements Comparable<TravelTime>{

	private double meanTravelTime;
	private int trimestre;
	private int sourceid;
	private int distid;
	private int hod ;
	private double standard_deviation_travel_time;
	public TravelTime(double pMeanTT, int pTrimestre, int pSourceid, int pDistid, int pHod, double pSDTT){
		meanTravelTime=pMeanTT;
		trimestre= pTrimestre;
		sourceid= pSourceid;
		distid= pDistid;
		hod =pHod;
		standard_deviation_travel_time = pSDTT;
	}
	public double darMeanTravelTime()
	{
		return meanTravelTime;
	}
	public double darStandardDeviation()
	{
		return standard_deviation_travel_time;
	}
	public double darHourOfDay()
	{
		return hod;
	}
	public int darDestinoID()
	{
		return distid;
	}
	public int darOrigenID()
	{
		return sourceid;
	}
	public int darTrimestre()
	{
		return trimestre;
	}



@Override
public int compareTo(TravelTime t) {
	if(meanTravelTime > t.meanTravelTime)
	{
		return 1;
	}
	else if(meanTravelTime < t.meanTravelTime)
	{
		return -1;
	}
	return 0;
}
}