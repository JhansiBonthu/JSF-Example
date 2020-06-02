package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.richfaces.component.SortOrder;

@ManagedBean
@ViewScoped
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SimpleCrudBean.class.getName());

	private List<Student> list;
    private Student item = new Student();
    private Student beforeEditItem = null;
    private boolean edit;
    private SortOrder namesOrder = SortOrder.unsorted;
    private SortOrder ageOrder = SortOrder.unsorted;
 
    public void sortByNames() {
    	ageOrder = SortOrder.unsorted;
        
        if (namesOrder.equals(SortOrder.ascending)) {
            setNamesOrder(SortOrder.descending);
        } else {
            setNamesOrder(SortOrder.ascending);
        }
    }
    
    public void sortByAge() {
    	namesOrder = SortOrder.unsorted;
        
        if (ageOrder.equals(SortOrder.ascending)) {
            setAgeOrder(SortOrder.descending);
        } else {
        	setAgeOrder(SortOrder.ascending);
        }
    }

    @PostConstruct
    public void init() {
        list = new ArrayList<Student>();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        if(!(item.getName().isEmpty() && (item.getAge() == 0 ))) {
        list.add(item);
        item = new Student();
        }
    }

    public void resetAdd() {
    	item = new Student();
    }

    public void edit(Student item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Student();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
    	if(this.item.getName().isEmpty())
    		this.item.setName(beforeEditItem.getName());
    	if(this.item.getAge() == 0)
    		this.item.setAge(beforeEditItem.getAge());
        this.item = new Student();
        edit = false;
    }

    public void delete(Student item) throws IOException {
    	// DAO save the delete
        list.remove(item);
    }

    public List<Student> getList() {
        return list;
    }

    public Student getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }

	public SortOrder getNamesOrder() {
		return namesOrder;
	}

	public void setNamesOrder(SortOrder namesOrder) {
		this.namesOrder = namesOrder;
	}

	public SortOrder getAgeOrder() {
		return ageOrder;
	}

	public void setAgeOrder(SortOrder ageOrder) {
		this.ageOrder = ageOrder;
	}
    
    

}