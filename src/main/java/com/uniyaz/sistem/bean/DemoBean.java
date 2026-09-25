package com.uniyaz.sistem.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("demoBean")
@ViewScoped
public class DemoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String barChartJson;

    @PostConstruct
    public void init() {
    	barChartJson = """
    			{
    			    type: 'bar',

    			    data: {
    			        labels: [
    			            'Bilgi İşlem',
    			            'Muhasebe',
    			            'İK',
    			            'PDKS',
    			            'Destek'
    			        ],

    			        datasets: [

    			            {
    			                label: 'Zamanında',
    			                data: [18, 30, 12, 25, 20],
    			                backgroundColor: '#42A5F5'
    			            },

    			            {
    			                label: 'Gecikti',
    			                data: [4, 7, 3, 6, 5],
    			                backgroundColor: '#EF5350'
    			            },

    			            {
    			                label: 'İzinli',
    			                data: [2, 3, 2, 2, 1],
    			                backgroundColor: '#FFA726'
    			            },

    			            {
    			                label: 'Raporlu',
    			                data: [1, 2, 1, 2, 2],
    			                backgroundColor: '#AB47BC'
    			            }

    			        ]
    			    },

    			    options: {

    			        responsive: true,

    			        maintainAspectRatio: false,

    			        plugins: {

    			            legend: {
    			                position: 'top'
    			            }

    			        },

    			        scales: {

    			            x: {
    			                stacked: false
    			            },

    			            y: {

    			                beginAtZero: true,

    			                ticks: {
    			                    precision: 0
    			                }

    			            }

    			        }

    			    }
    			}
    			""";
    }

    public String getBarChartJson() {
        return barChartJson;
    }
}