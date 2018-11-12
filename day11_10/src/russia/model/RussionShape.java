package russia.model;

import java.util.Random;

public abstract class RussionShape {
	private int angle;

	public RussionShape(int angel) {
		this.angle = angel;
	}

	public int getAngel() {
		return angle;
	}

	public void setAngel(int angel) {
		this.angle = angel;
	}

	public abstract int[][] getPosi();

	public static class FaShape extends RussionShape {

		public FaShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			return new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
		}

	}

	public static class RecShape extends RussionShape {
		public RecShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0 || this.getAngel() == 2) {
				return new int[][] { { 0, 0 }, { 2, 0 }, { 1, 0 }, { 3, 0 } };
			} else {
				return new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
			}
		}
	}

	public static class LShape extends RussionShape {
		public LShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0) {
				return new int[][] { { 0, 0 }, { 2, 0 }, { 1, 0 }, { 2, 1 } };
			} else if (this.getAngel() == 1) {
				return new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } };
			} else if (this.getAngel() == 2) {
				return new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
			} else {
				return new int[][] { { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
			}

		}
	}

	public static class ReLShape extends RussionShape {
		public ReLShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0) {
				return new int[][] { { 0, 1 }, { 2, 1 }, { 1, 1 }, { 2, 0 } };
			} else if (this.getAngel() == 1) {
				return new int[][] { { 0, 0 }, { 1, 1 }, { 1, 2 }, { 1, 0 } };
			} else if (this.getAngel() == 2) {
				return new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } };
			} else {
				return new int[][] { { 0, 2 }, { 0, 0 }, { 0, 1 }, { 1, 2 } };
			}

		}
	}

	public static class ZShape extends RussionShape {
		public ZShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0 || this.getAngel() == 2) {
				return new int[][] { { 0, 1 }, { 1, 2 }, { 1, 1 }, { 0, 0 } };
			} else {
				return new int[][] { { 0, 1 }, { 1, 1 }, { 2, 0 }, { 1, 0 } };
			}

		}
	}

	public static class ReZShape extends RussionShape {
		public ReZShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0 || this.getAngel() == 2) {
				return new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 0, 2 } };
			} else {
				return new int[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 1, 0 } };
			}

		}
	}

	public static class TShape extends RussionShape {
		public TShape(int angle) {
			super(angle);
		}

		@Override
		public int[][] getPosi() {
			if (this.getAngel() == 0) {
				return new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
			} else if (this.getAngel() == 1) {
				return new int[][] { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 1, 0 } };
			} else if (this.getAngel() == 2) {
				return new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } };
			} else {
				return new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
			}

		}
	}

	public static RussionShape getShape() {
		int shape = new Random().nextInt(7);
		int angle = new Random().nextInt(3);
		switch (shape) {
		case 0:
			return new FaShape(angle);
		case 1:
			return new RecShape(angle);
		case 2:
			return new LShape(angle);
		case 3:
			return new ReLShape(angle);
		case 4:
			return new ZShape(angle);
		case 5:
			return new ReZShape(angle);
		default:
			return new TShape(angle);

		}

	}
	
	//旋转
	public void reAngle(){
		this.angle++;
		if(angle>=4){
			angle=0;
		}
	}
}
