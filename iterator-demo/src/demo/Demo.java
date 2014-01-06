package demo;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Demo {

	@Test
	public void error () {
		List<String> list = new ArrayList<String>();
		list.add("001");
		list.add("002");
		list.add("003");
		list.add("004");
		list.add("005");
		
		List<String> del = new ArrayList<String>();
		del.add("003");
		del.add("004");
		del.add("005");
		
		try {
			for (String str : list) { //用了集合的iterator() 方法
				if (del.contains(str)) {
					list.remove(str);
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(e instanceof ConcurrentModificationException);
		}
	}
	
	/**
	 * Iterator被创建的时候，建立了一个内存索引表（单链表），这个索引表指向原来的对象，
	 * 当原来的对象数量改变的时候，这个索引表的内容没有同步改变，所以当索引指针往下移动的时候，
	 * 便找不到要迭代的对象
	 */
	@Test
	public void success () {
		List<String> list = new ArrayList<String>();
		list.add("001");
		list.add("002");
		list.add("003");
		list.add("004");
		list.add("005");
		
		List<String> del = new ArrayList<String>();
		del.add("003");
		del.add("004");
		del.add("005");
		
		list.removeAll(del);
		System.out.println("list:" + list);
		
		Assert.assertEquals(list.size(), 2);
	}

}
