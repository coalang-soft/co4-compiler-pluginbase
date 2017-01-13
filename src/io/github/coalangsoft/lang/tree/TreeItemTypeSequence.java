package io.github.coalangsoft.lang.tree;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.BaseSequence;

public class TreeItemTypeSequence extends BaseSequence<TreeItemType>{

	public TreeItemTypeSequence(TreeItemType[] values) {
		super(makeTool(new Func<Integer, TreeItemType[]>() {

			public TreeItemType[] call(Integer p) {
				return new TreeItemType[p];
			}
			
		}), values);
	}

}
