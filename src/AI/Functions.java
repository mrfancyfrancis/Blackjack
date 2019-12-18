package AI;

import java.util.ArrayList;

import Controller.GameFunctions;

public class Functions {
	static ArrayList<float[]> data = new ArrayList<float[]>();
	public static void main(String[] args)
	{
		initializeData();
		for(int i = 3; i <= 21; i++)
		{
			System.out.println(i+" "+predict(i));
		}
		displayData();
		
	}
	public static void initializeData()
	{
		if(data.size() == 0)
		{
			for(int i = 1; i <= 10; i++)
			{
				float[] t = {i,100};
				data.add(t);
			}
			for(int i = 22; i >= 19; i--)
			{
				float[] t = {i,1};
				data.add(t);
			}
			/*
			prices.append([3,100])
			prices.append([4,100])
			prices.append([5,100])
			prices.append([6,100])
			prices.append([7,100])
			prices.append([8,100])
			prices.append([9,100])
			prices.append([10,100])
			prices.append([11,100])
			prices.append([19,1.2])
			prices.append([20,1])
			 */
		}
	}
	public static void displayData()
	{
		for(float[] d:data)
		{
			System.out.println(d[0]+" "+d[1]);
		}
	}
	public static float predict(int x)
	{
		float xs = 0;
		float ys = 0;
		float x2s = 0;
		float y2s = 0;
		float xys = 0;
		for(float[] d:data)
		{
			xs+=d[0];
			ys+=d[1];
			x2s+=d[0]*d[0];
			y2s+=d[1]*d[1];
			xys+=d[0]*d[1];
		}
		//System.out.println(xs+" "+ys+" "+x2s+" "+xys);
		float n = data.size();
		float a = (ys*x2s-xs*xys)/(n*x2s-(xs*xs));
		float b = (n*(xys)-xs*ys)/(n*x2s-(xs*xs));
		float[] t = {(float)x,(b*x+a)};
		//data.add(t);
		return b*x+a;
	}
	public static boolean decision()
	{
		if(GameFunctions.p1.countHands() >= 21)
			return false;
		else if(predict(GameFunctions.p1.countHands()) >= 50)
			return true;
		else
			return false;
	}
	public static void addData(int x,int modifier)
	{
		float[] input = {x,predict(x)+modifier};
		data.add(input);
	}
	public static int getDataSize()
	{
		return data.size();
	}
}