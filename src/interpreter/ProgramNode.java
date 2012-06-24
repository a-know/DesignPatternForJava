package interpreter;

// <program> ::= program <command list>
public class ProgramNode extends Node {
	private Node commandListNode;

	public void parse(Context c) throws ParseException{
		c.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(c);
	}

	public String toString(){
		return "[program " + commandListNode + "]";
	}
}
