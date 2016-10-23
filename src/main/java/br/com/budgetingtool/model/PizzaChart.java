package br.com.budgetingtool.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaChart {
	private static final String[] CHART_COLORS = {"blue","yellow","green","red","purple","black","pink","gray"};
	private List<Datasets> datasets;
	private List<String> labels;
	
	public PizzaChart(){
		this.datasets = new ArrayList<Datasets>();
		this.labels = new ArrayList<String>();
	}
	
	public PizzaChart(List<Double> values, List<String> categories){
		this();
		final List<String> colors = Arrays.asList(Arrays.copyOfRange(CHART_COLORS, 0, categories.size()));
		getDatasets().add(new Datasets(values, colors));
		setLabels(categories);
	}

	public List<Datasets> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<Datasets> datasets) {
		this.datasets = datasets;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
}

class Datasets{
	private List<Double> data;
	private List<String> backgroundColor;
	
	
	public Datasets() {	
		this.data = new ArrayList<Double>();
		this.backgroundColor = new ArrayList<String>();
	}
	
	public Datasets(final List<Double> data, final List<String> bgColor){
		this();
		setData(data);
		setBackgroundColor(bgColor);
	}
	
	public List<Double> getData() {
		return data;
	}
	public void setData(List<Double> data) {
		this.data = data;
	}
	public List<String> getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	
}