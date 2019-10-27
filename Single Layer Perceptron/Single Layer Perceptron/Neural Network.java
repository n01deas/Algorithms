package Single Layer Perceptron;

import java.util.ArrayList;

public class NeuralNetwork {
	
	private ArrayList<InputNeuron> inputNeurons = new ArrayList<>();
	
	private ArrayList<WorkingNeuron> outputNeurons = new ArrayList<>();
	
	
	/*
	 * Erstellen von Outputneuronen
	 */
	
	public WorkingNeuron createNewOutput() {
		WorkingNeuron wn  = new WorkingNeuron();
		outputNeurons.add(wn);
		return wn;
	}

	
	
	/*
	 * erstellen eines neuen Inputneurons
	 */
	public InputNeuron createNewInput() {
		InputNeuron in = new InputNeuron();
		inputNeurons.add(in);
		return in;
	}
	
	
	/*
	 * Neuronen miteinander vermaschen / verbinden
	 */
	public void createFullMesh() {
		for (WorkingNeuron wn : outputNeurons) {
			for (InputNeuron in : inputNeurons) {
				wn.addConnection(new Connection(in, 0));
			}
			
		}
	}
		
	
	public void createFullMesh(float ...weights) {
		if(weights.length != inputNeurons.size() * outputNeurons.size()) {
			throw new RuntimeException();
		}
		
		int index = 0;
		
		for (WorkingNeuron wn : outputNeurons) {
			for (InputNeuron in : inputNeurons) {
				wn.addConnection(new Connection(in, weights[index++]));
			}
			
		}
		
	}
}
