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
                    labels: ['Bilgi İşlem', 'Muhasebe', 'İK', 'PDKS', 'Destek'],
                    datasets: [{
                        label: 'Personel',
                        data: [25, 42, 18, 35, 28],
                        backgroundColor: [
                            '#42A5F5',
                            '#66BB6A',
                            '#FFA726',
                            '#AB47BC',
                            '#26A69A'
                        ]
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    scales: {
                        y: {
                            beginAtZero: true
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