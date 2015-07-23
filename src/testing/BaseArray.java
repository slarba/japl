package testing;

/**
 * Base for primitive-containing arrays
 * 
 * @author mtl
 *
 */
public abstract class BaseArray implements Array {
	protected Dimensions dims;
	private int depth;
	
	public BaseArray() {
		dims = Dimensions.EMPTY;
		depth = 1;
	}
	
	public BaseArray(Dimensions dims) {
		this.dims = dims;
		depth = 1;
	}
		
	@Override
	public int depth() {
		return depth;
	}

	@Override
	public Array reshape(int... newShape) {
		return reshape(new Dimensions(newShape));
	}

	@Override
	public Array atA(int... indx) {
		throw new DomainError();
	}

	@Override
	public Array atA(int idx) {
		throw new DomainError();
	}

	@Override
	public long atI(int... indx) {
		throw new DomainError();
	}

	@Override
	public long atI(int idx) {
		throw new DomainError();
	}

	@Override
	public double atD(int... indx) {
		throw new DomainError();
	}

	@Override
	public double atD(int idx) {
		throw new DomainError();
	}

	@Override
	public char atC(int... indx) {
		throw new DomainError();
	}

	@Override
	public char atC(int idx) {
		throw new DomainError();
	}

	@Override
	public boolean isScalar() {
		return false;
	}

	@Override
	public Dimensions dims() {
		return dims;
	}

	@Override
	public int length() {
		return dims.length();
	}

	@Override
	public int rank() {
		return dims.rank();
	}

	@Override
	public boolean isNested() {
		return false;
	}

	@Override
	public void setI(int idx, long val) {
		throw new DomainError();
	}

	@Override
	public void setD(int idx, double val) {
		throw new DomainError();
	}

	@Override
	public void setC(int idx, char val) {
		throw new DomainError();
	}

	@Override
	public void setA(int idx, Array val) {
		throw new DomainError();
	}

}
