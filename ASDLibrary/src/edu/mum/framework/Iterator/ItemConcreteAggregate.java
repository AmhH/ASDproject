package edu.mum.framework.Iterator;

import java.util.List;

public class ItemConcreteAggregate<T> implements Aggregate<T> {
	private List<T> list;

	public ItemConcreteAggregate(List<T> list) {
		this.list = list;

	}

	@Override
	public Iterator<T> getIterator() {
		return new GenericIterator<T>();
	}

	@SuppressWarnings("hiding")
	private class GenericIterator<T> implements Iterator<T> {
		int index;

		@Override
		public boolean hasNext() {
			if (index < list.size())
				return true;
			return false;

		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if (this.hasNext()) {
				//System.out.println("Index :" + index);
				return (T) list.get(index++);

			}
			return null;
		}

	}

}
