package testing;

public class IotaArray extends BaseArray {
	private int n;

	public IotaArray(int n) {
		this.n = n;
	}
	
	@Override
	public long atI(int... indx) {
		return atI(dims.calculateIndex(indx));
	}

	@Override
	public long atI(int idx) {
		return (idx%n)+1;
	}

	@Override
	public int type() {
		return INTEGER;
	}

	@Override
	public int actualLength() {
		return n;
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return null;
	}

	@Override
	public Array unInitializedCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
