var chartData = decodeHtml(chartData);
var chartData = JSON.parse(chartData);
var arrayLength =  chartData.length;
var numericData = [];
var labelData = [];
for(var i=0; i<arrayLength;i++){
    numericData[i]=chartData[i].val;
    labelData[i]=chartData[i].label;

}




 
const data = {
labels: labelData,
datasets: [{
label: 'My First dataset',
backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
data: numericData,
}]
};
 
const config = {
type: 'pie',
data: data,
options: {
    title: {
        display: true,
        text: 'Project Statuses'
    }
}
};
 
const myChart = new Chart(
document.getElementById('myPieChart'),
config
);
function decodeHtml(html){
    let txt = document.createElement("textarea");
    txt.innerHTML=html;
    return txt.value;

}
