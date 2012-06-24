package command.command;

import java.awt.Point;

import command.drawer.Drawable;

public class DrawCommand implements Command {

	protected Drawable drawable;
	private Point position;

	public DrawCommand(Drawable d, Point p){
		this.drawable = d;
		this.position = p;
	}
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}

}
