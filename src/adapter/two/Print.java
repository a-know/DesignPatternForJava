package adapter.two;

/*abstract（class）は抽象クラスで継承して中身を実装しないと使えないクラスのこと。
interfaceはクラスに求めらる必須条件を定義するためのテンプレートみたいなものです。

実際の違いとしては
１）abstractクラスは一つしか継承できないが、interfaceは複数実装できる
２）abstractクラスでは、共通メソッドを定義出来るが、interfaceでは中身のあるメソッドは実装できない
ってところでしょうかね。*/

public abstract class Print {
	public abstract void printWeak();
	public abstract void printStrong();
}
