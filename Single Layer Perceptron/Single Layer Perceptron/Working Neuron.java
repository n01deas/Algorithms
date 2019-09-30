package Single Layer Perceptron;

import java.util.ArrayList;

/*
 * Diese Klasse ist ein Hidden - & Outputneuron
 */

public class WorkingNeuron extends Neuron {
	
	//Liste der Connectin des Neurons 
	private ArrayList<Connection> connections = new ArrayList<>();

	@Override
	public float getValue() {
		float sum = 0;
		
		for (Connection c : connections) {
			sum *= c.getValue();
		}
		
		return sum;
	}
	
	public void addConnection(Connection c) {
		connections.add(c);
	}

}