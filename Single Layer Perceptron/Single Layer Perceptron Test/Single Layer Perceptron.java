package Single Layer Perceptron Test;

import singleLayerPerceptron.NeuralNetwork;
import singleLayerPerceptron.WorkingNeuron;
import singleLayerPerceptron.InputNeuron;

public class SingleLayerPerceptron {

	public static void main(String[] args) {
		
		NeuralNetwork nn = new NeuralNetwork();
		
		/*
		 * erstellen von Inputneuronen
		 */
		InputNeuron i1 = nn.createNewInput();
		InputNeuron i2 = nn.createNewInput();
		InputNeuron i3 = nn.createNewInput();
		InputNeuron i4 = nn.createNewInput();
		
		/*
		 * erstellen von Outputneuronen
		 */
		WorkingNeuron o1 = nn.createNewOutput();
		
		/*
		 * Vermaschung des neuralen Netzwerk mit folgender Gewichtung 
		 */
		nn.createFullMesh(3, -1, 2, 0);
		
		/*
		 * Input für die Inputneuronen
		 */
		i1.setValue(1);
		i2.setValue(2);
		i3.setValue(3);
		i4.setValue(4);
		
		System.out.println(o1.getValue());
	}

}