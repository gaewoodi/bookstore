google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Day', 'Ebook', 'book'],
    ['06. 21', 1000, 400],
    ['06. 22', 1170, 460],
    ['06. 23', 660, 1120],
    ['06. 24', 1030, 540],
    ['06. 25', 1020, 710]
  ]);

  var options = {
    title: '판매량',
    curveType: 'function',
    legend: { position: 'bottom' }
  };

  var chart = new google.visualization.LineChart(document.getElementById('curve_pay_chart'));

  chart.draw(data, options);
}