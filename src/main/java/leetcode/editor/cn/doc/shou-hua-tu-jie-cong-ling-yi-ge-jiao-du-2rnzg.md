

#### 把二叉树看成有向图
![image.png](https://pic.leetcode-cn.com/1615490838-ZLELME-image.png)


- 二叉树本来就是图，看成有向图，一条有向边带来一个入度和一个出度，有入有出，二叉树的总入度肯定等于总出度，也等于边数。即，遍历到最后，总入度肯定等于总出度

> **概念：如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度。**
![image.png](https://pic.leetcode-cn.com/1615490741-YkAewF-image.png)
- 遍历过程中：
    - 根节点提供 2 个出度
    - 根节点以外的真实节点，提供 2 个出度， 1 个入度
    - null 节点提供 1 个入度

- **还没遍历到最后呢**？**肯定不会出现『入度 >= 出度』的时刻**。**为什么？**
- 看图1，提供 1 个出度可以理解为提供一个挂载点，提供 1 个入度为消耗一个挂载点
- 入度 >= 出度意味着，当前已遍历的节点，消耗的挂载点已经大于等于提供的挂载点
- 意味着，已经没有办法挂载接下来遍历的节点了，还有要挂的，但挂满了，就是非法的。





#### 代码与注释

```javascript []
var isValidSerialization = function(preorder) {
    if (preorder == "#") { // 特例
        return true
    }
    let indegree = 0, outdegree = 0 // 初始 入度出度
    const nodes = preorder.split(",") // 转成数组
    
    for (let i = 0; i < nodes.length; i++) { // 遍历数组
        if (i == 0) { // 根节点
            if (nodes[i] == "#") { // #,#,1 这样的 是非法的
                return false
            }
            outdegree += 2 // 根节点  出度+2
            continue
        }
        if (nodes[i] == "#") { // null节点，入度+1
			indegree += 1  
		} else {               // 非空节点 入度+1 出度+2
            indegree += 1  
            outdegree += 2
		}
        if (i != nodes.length - 1 && indegree >= outdegree) {
            return false//一直保持indegree<outdegree，直到最后才indegree==outdegree，做不到就false
        }
    }
    return indegree == outdegree // 最后肯定入度==出度
};
```
```golang []
func isValidSerialization(preorder string) bool {
    if preorder == "#" {
        return true
    }
    indegree, outdegree := 0, 0    
    nodes := strings.Split(preorder, ",")
    
    for i := 0; i < len(nodes); i++ {
        if i == 0 {
            if nodes[i] == "#" {
                return false
            }
            outdegree = 2
            continue
        }
        if nodes[i] == "#" {
			indegree += 1  
		} else {
            indegree += 1  
            outdegree += 2
		}
        if i != len(nodes)-1 && indegree >= outdegree {
            return false
        }
    }
    return indegree == outdegree
}
```
#### 复盘总结

walk 一个二叉树，walk 过的分支。
要么挂满了然后遇到新的空闲可挂的节点
要么还没挂满
不可能挂满了还遇到消耗挂载点的节点。
#### 从节点个数上看
*n_{0}* —— 叶子节点的个数 
*n_{1}* —— 有一个子节点的节点个数
*n_{2}* —— 有两个子节点的节点个数
*n_{null}* —— null 节点的个数

有：*n_{总}=n_{0}+n_{1}+n_{2}* 
有：*n_{null}= 2 n_{0} + n_{1}* 

除了最上面的根节点，其他节点都是“孩子”，我们用子节点的个数，来表示总个数：


*n_{总}=1+n_{1}+2n_{2}* 

1 是最上面的根节点，n1 是有1个孩子的爸爸的孩子个数，*2n_{2}* 是有2个孩子的爸爸的孩子个数。

消掉 *n_{总}* 可得： *1+n_{1}+2n_{2}=n_{0}+n_{1}+n_{2}*

消掉 *n_{1}* 可得：*1+n_{2}=n_{0}*

*2+2n_{2}=n_{null}-n_{1}*

加入 *n_{0}* 可得：

*1+n_{2}+n_{0}=n_{null}-n_{1}*

*1+n_{2}+n_{0}+n_{1}=n_{null}*

*1+n_{总}=n_{null}*



*n_{null}-n_{总}= 1*

#### 提出结论：
前序序列化的最后一个字符肯定是 #，在它之前的前序序列化，无论在哪一个时刻，都不会出现 *n_{null}-n_{总} == 1*

即直到遍历到最后一个 null ，才会出现 null 个数比非空节点个数多 1



#### 为什么？可以思考一下
提示：有1个父亲2个孩子——1个入度2个出度。

### 谢谢收看。觉得有意思的可以点个赞。