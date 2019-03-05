package cn.alibaba.yimai.query;

public class BaseQuery {
    private String keyword;
    //当前页
    private Integer page=1;
    //每页展示数据
    private Integer rows=10;
    //开始的索引=（当前页-1）*size
    private Integer start=0 ;//从哪里开始

    public Integer getStart() {
        // (page-1)*size
        return (this.page-1)*this.rows;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
