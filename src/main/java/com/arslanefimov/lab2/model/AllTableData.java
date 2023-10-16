package com.arslanefimov.lab2.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

public class AllTableData implements Serializable {

    private final LinkedList<TableData> tableDataList;

    public AllTableData(){
        tableDataList = new LinkedList<>();
    }
    public AllTableData(LinkedList<TableData> tableDataList){
        this.tableDataList = tableDataList;
    }

    public void addData(TableData tableData){
        tableDataList.add(tableData);
    }

    public LinkedList<TableData> getTableDataList() {
        return tableDataList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTableData that = (AllTableData) o;
        return Objects.equals(tableDataList, that.tableDataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableDataList);
    }

    @Override
    public String toString() {
        return "AllTableData{" +
                "tableDataList=" + tableDataList +
                '}';
    }
}
