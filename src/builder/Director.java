package builder;

public class Director {
	private Builder builder;
	public Director(Builder b){
		this.builder = b;
	}
	public void construct(){
		builder.makeTitle("Greeting");
		builder.makeString("朝から昼にかけて");
		builder.makeItems(new String[]{
				"おはようございます",
				"こんにちは"
		});
		builder.makeString("夜に");
		builder.makeItems(new String[]{
				"こんばんわ",
				"おやすみなさい",
				"さようなら"
		});
		builder.close();
	}
}
