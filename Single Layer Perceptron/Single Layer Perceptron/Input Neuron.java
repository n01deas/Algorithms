package Single Layer Perceptron;

public class InputNeuron extends Neuron{
	
	
	private float value = 0;
	
	
	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public float getValue() {

		return value;
	}
	
	

}