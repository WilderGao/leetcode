package 广度优先搜索;

import java.util.List;

/**
 * @author WilderGao
 * time 2018-09-10 21:35
 * motto : everything is no in vain
 * description
 */
public class NNode {
    private int val;
    private List<NNode> children;

    public NNode(){}

    public NNode(int val, List<NNode> children){
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<NNode> getChildren() {
        return children;
    }

    public void setChildren(List<NNode> children) {
        this.children = children;
    }
}
