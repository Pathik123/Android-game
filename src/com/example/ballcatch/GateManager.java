package com.example.ballcatch;

public class GateManager {
	Gate gates[];
	
	int radius = 50;
	
	public GateManager()
	{
		gates = new Gate[4];
	    gates[0] = new Gate(255, 0, 0, 240, 0); 	// top gate
	    gates[1] = new Gate(0, 0, 255, 0, 400); 	// left gate
	    gates[2] = new Gate(0, 255, 0, 480, 400);	// right gate
	    gates[3] = new Gate(255, 144, 0, 240, 800);	// bottom gate
	}
	
	public Gate getGate(int key)
	{
		return gates[key];
	}
	
	public int getRadius()
	{
		return radius;
	}
}
