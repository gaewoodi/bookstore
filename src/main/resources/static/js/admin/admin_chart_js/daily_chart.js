google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Day', 'Ebook'],
    ['06. 21', 1000],
    ['06. 22', 1170],
    ['06. 23', 660],
    ['06. 24', 1030],
    ['06. 25', 1020]
  ]);

  var options = {
    title: '접속자 수',
    curveType: 'function',
    legend: { position: 'bottom' }
  };

  var chart = new google.visualization.LineChart(document.getElementById('curve_daily_chart'));

  chart.draw(data, options);
}