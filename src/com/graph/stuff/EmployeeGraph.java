package com.graph.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class EmployeeGraph {
    
    private Map<String, Set<String>> orgAdjMapList = new LinkedHashMap<>();
    private Map<String, Employee> empMap = new HashMap<>();
    private String rootNode;

    public void add(String id, String name, String mId){
        if(!empMap.containsKey(id)){
            Employee e = new Employee(id, name, mId);
            empMap.put(id, e);
            if(!orgAdjMapList.containsKey(id)){
                orgAdjMapList.put(id, new LinkedHashSet<>());
            }
            if(!mId.equals("-1") && orgAdjMapList.containsKey(mId)){
                orgAdjMapList.get(mId).add(id);
            } 
            if(rootNode == null){
                rootNode = id;
            }
        }
    }

    public void remove(String id){
        // remove from emp map
        // remove from org map
        // all the reportees if any should report to the removed person's manager now
        // if no manager is present for the employee to be removed, the reportees goes to the base

        if(empMap.containsKey(id)){
            empMap.remove(id);
        }

        if(orgAdjMapList.containsKey(id)){
            Set<String> reportees = orgAdjMapList.get(id);
            orgAdjMapList.remove(id);
            String managerId = null;
            for(Map.Entry<String,Set<String>> entry : orgAdjMapList.entrySet()){
                if(entry.getValue().contains(id)){
                    managerId = entry.getKey();
                    break;
                }
            }
            if(managerId != null){
                orgAdjMapList.get(managerId).remove(id);
                orgAdjMapList.get(managerId).addAll(reportees);
            }
        }
    }

    public void printInOrder(){
        printInOrderPrinter(rootNode, 0);
    }

    private void printInOrderPrinter(String rootNode2, int level) {
        if(orgAdjMapList.get(rootNode2).isEmpty()){
            printerEmp(rootNode2,  level);
            return;
        } else {
            printerEmp(rootNode2, level);
            for(String node : orgAdjMapList.get(rootNode2)){
                
                printInOrderPrinter(node, level+1);
            }
        }
    }

    private void printerEmp(String node, int level) {
        for(int i=0;i<level;i++){
            System.out.print(" ");
        }
        System.out.println(empMap.get(node).getName()+"---"+empMap.get(node).getId());
    }

    public void print() {
        //print all employees first
        // dfs
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        if(rootNode == null){
            System.out.println("empty");
            return;
        }
        stack.add(rootNode);
        
        while(!stack.isEmpty()){
            String node = stack.pop();
            if(!visited.contains(node)){
                printerEmp(node);
                visited.add(node);
                for(String reportee : orgAdjMapList.get(node)){
                    stack.push(reportee);
                }
            }

        }
        System.out.println(visited);
    }

    private void printerEmp(String node) {
        System.out.println(empMap.get(node).getName()+"---"+empMap.get(node).getId());
    }

    public Map<String, Set<String>> getOrgAdjMapList() {
        return orgAdjMapList;
    }

    public void setOrgAdjMapList(Map<String, Set<String>> orgAdjMapList) {
        this.orgAdjMapList = orgAdjMapList;
    }

    public Map<String, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<String, Employee> empMap) {
        this.empMap = empMap;
    }

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public String toString() {
        return "EmployeeGraph [empMap=" + empMap + ", orgAdjMapList=" + orgAdjMapList + ", rootNode=" + rootNode + "]";
    }

}
