package usta.onur.ceng599.model;

public enum GPRCommand {
	GO10(10), GO11(11), GO12(12), GO13(13), GO14(14), GO15(15), GO20(20), GO21(
			21), GO22(22), GO23(23), GO24(24), GO25(25), GO30(30), GO31(31), GO32(
			32), GO33(33), GO34(34), GO35(35), GO40(40), GO41(41), GO42(42), GO43(
			43), GO44(44), GO45(45), GO50(50), GO51(51), GO52(52), GO53(53), GO54(
			54), GO55(55), GO60(60), GO61(61), GO62(62), GO63(63), GO64(64), GO65(
			65), PUSH1(71), PUSH2(72), PUSH3(73), PUSH4(74), PUSH5(75), PUSH6(
			76), PULL1(81), PULL2(82), PULL3(83), PULL4(84), PULL5(85), PULL6(
			86), TOUCH1(91), TOUCH2(92), TOUCH3(93), TOUCH4(94), TOUCH5(95), TOUCH6(
			96);

	int value;

	private GPRCommand(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
