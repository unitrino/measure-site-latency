google.charts.load('current', {packages: ['corechart','timeline']});

google.setOnLoadCallback(drawGraphics);


function drawBasic() {

      var output = [];

      for (var type in data2) {
        output.push([data2[type]["url"],data2[type]["end"] - data2[type]["start"]]);
      }

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Urls');
      data.addColumn('number', 'Latency');

      data.addRows(output);

      var options = {
        hAxis: { textPosition: 'none' },
        vAxis: {
          title: 'Latency in ms'
        },
        pointSize: 3
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }


  function drawChart() {


      var output2 = [];

      for (var type in data2) {
        output2.push([data2[type]["url"],data2[type]["start"],data2[type]["end"]]);
      }

    var dataTable = new google.visualization.DataTable();

    dataTable.addColumn({ type: 'string', id: 'URL' });
    dataTable.addColumn({ type: 'number', id: 'Start' });
    dataTable.addColumn({ type: 'number', id: 'End' });

    dataTable.addRows(output2);

    var elem = document.getElementById('elemdiv');

    var chart = new google.visualization.Timeline(elem);

    chart.draw(dataTable);
  }

  function drawGraphics () {
    drawBasic()
    drawChart()

  }

var output = [];

      for (var type in data2) {
        output.push([data2[type]["url"],data2[type]["status"],data2[type]["end"] - data2[type]["start"]]);
}

function sortASC(a, b){
  if(a[2] > b[2])
     return 1
  if(a[2] < b[2])
     return -1
  return 0
};

function sortDESC(a, b){
  if(a[2] > b[2])
     return -1
  if(a[2] < b[2])
     return 1
  return 0
};


var allValue = output.slice()
allValue.sort(sortASC);
$(document).ready(function(){
        $.each(allValue, function(i,item){
          if(item[1] != 200) {
            $('#table_all_value > tbody:last').append('<tr bgcolor="#d58b92"><td>'+item[0]+'</td><td id = "second_row">'+item[1]+'</td><td id = "third_row">'+item[2]+'</td></tr>');
          }
          else {
             $('#table_all_value > tbody:last').append('<tr><td>'+item[0]+'</td><td id = "second_row">'+item[1]+'</td><td id = "third_row">'+item[2]+'</td></tr>');
          }
        });
});


var slowerPages = output.slice()
var slowerPages = slowerPages.sort(sortDESC).slice(0,10);
$(document).ready(function(){
        $.each(slowerPages, function(i,item){
            if(item[1] != 200) {
            $('#table_slow_value > tbody:last').append('<tr bgcolor="#d58b92"><td>'+item[0]+'</td><td id = "second_row>'+item[1]+'</td><td id = "third_row">'+item[2]+'</td></tr>');
          }
          else {
             $('#table_slow_value > tbody:last').append('<tr><td>'+item[0]+'</td><td id = "second_row">'+item[1]+'</td><td id = "third_row">'+item[2]+'</td></tr>');
          }
        });
});
