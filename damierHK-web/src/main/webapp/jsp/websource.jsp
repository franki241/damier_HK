<%@page import="java.io.PrintWriter"%>
<!--page import="dao.DamierGameDao"  prefix="Game" %>-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Page Title</title>
   <style>
span {
    display: block;
    height: 31px;
    width: 31px; 
    border-radius: 40px; /* or 50% */
    /*background-color: white;*/
	margin-bottom: 16px;
	margin-left: 14px;
	border: 2px solid white;
}

#dam2,#dam4,#dam6,#dam8,#dam10,#dam11,#dam13,#dam15,#dam17,#dam19,#dam22,#dam24,#dam26,#dam28,#dam30,#dam31,#dam33,#dam35,#dam37,#dam39,#dam42,#dam44,#dam46,#dam48,#dam50{
    display: block;
    height: 31px;
    width: 31px; 
    border-radius: 40px; /* or 50% */
    /*background-color: white;*/
	margin-bottom: 16px;
	margin-left: 14px;
	border: 2px solid black;
}

#dam51,#dam53,#dam55,#dam57,#dam59,#dam62,#dam64,#dam66,#dam68,#dam70,#dam71,#dam73,#dam75,#dam77,#dam79,#dam82,#dam84,#dam86,#dam88,#dam90,#dam91,#dam93,#dam95,#dam97,#dam99{
    display: block;
    height: 31px;
    width: 31px; 
    border-radius: 40px; /* or 50% */
    /*background-color: white;*/
	margin-bottom: 16px;
	margin-left: 14px;
	border: 2px solid black;
}

input[type=button] {
	 border: 2px solid #a1a1a1;
	padding: 8px 30px; 
    background: yellow;
	width: 140px;
    border-radius: 20px;
}
</style>
  
 
</head>

<body style="background-image:url('images/arriereplan.jpg'); background-repeat: no-repeat;">
<center><h2><font color="#22129c">Checkers</font></h2></center>
<center><font color="blue"><h3 id="resultat"></h3></font></center>
<br/>

<p style="font-size:20px;"><b>score Red :</b>&nbsp;<font color="red"><b id="redscore"></b></font></p>
<p style="font-size:20px;"><b>score Green :</b>&nbsp;<font color="red"><b id="greenscore"></b></font></p>
<!-- ajout dbb
GameEntry winnerColor = (GameEntry) getWinnerColor(); %> </p>
 -->
<div id="test" >
		<table align="center" class="test" style="background-image:url('images/damiers.gif'); background-repeat: no-repeat;">
			<tr><td><span id="dam1" onclick="action('dam1')"></span></td>
		
			<td><span id="dam2" onclick="action('dam2')"></span></td>
		
			<td><span id="dam3" onclick="action('dam3')"></span></td>
		
			<td><span id="dam4" onclick="action('dam4')"></span></td>
		
			<td><span id="dam5" onclick="action('dam5')"></span></td>
		
			<td><span id="dam6" onclick="action('dam6')"></span></td>
		
			<td><span id="dam7" onclick="action('dam7')"></span></td>
		
			<td><span id="dam8" onclick="action('dam8')"></span></td>
		
			<td><span id="dam9" onclick="action('dam9')"></span></td>
		
			<td><span id="dam10" onclick="action('dam10')"></span></td></tr>
			
			
			<tr><td><span id="dam11" onclick="action('dam11')"></span></td>
		
			<td><span id="dam12" onclick="action('dam12')"></span></td>
		
			<td><span id="dam13" onclick="action('dam13')"></span></td>
		
			<td><span id="dam14" onclick="action('dam14')"></span></td>
		
			<td><span id="dam15" onclick="action('dam15')"></span></td>
		
			<td><span id="dam16" onclick="action('dam16')"></span></td>
		
			<td><span id="dam17" onclick="action('dam17')"></span></td>
		
			<td><span id="dam18" onclick="action('dam18')"></span></td>
		
			<td><span id="dam19" onclick="action('dam19')"></span></td>
		
			<td><span id="dam20" onclick="action('dam20')"></span></td></tr>
			
			
			<tr><td><span id="dam21" onclick="action('dam21')"></span></td>
		
			<td><span id="dam22" onclick="action('dam22')"></span></td>
		
			<td><span id="dam23" onclick="action('dam23')"></span></td>
		
			<td><span id="dam24" onclick="action('dam24')"></span></td>
		
			<td><span id="dam25" onclick="action('dam25')"></span></td>
		
			<td><span id="dam26" onclick="action('dam26')"></span></td>
		
			<td><span id="dam27" onclick="action('dam27')"></span></td>
		
			<td><span id="dam28" onclick="action('dam28')"></span></td>
		
			<td><span id="dam29" onclick="action('dam29')"></span></td>
		
			<td><span id="dam30" onclick="action('dam30')"></span></td></tr>
			
			
			<tr><td><span id="dam31" onclick="action('dam31')"></span></td>
		
			<td><span id="dam32" onclick="action('dam32')"></span></td>
		
			<td><span id="dam33" onclick="action('dam33')"></span></td>
		
			<td><span id="dam34" onclick="action('dam34')"></span></td>
		
			<td><span id="dam35" onclick="action('dam35')"></span></td>
		
			<td><span id="dam36" onclick="action('dam36')"></span></td>
		
			<td><span id="dam37" onclick="action('dam37')"></span></td>
		
			<td><span id="dam38" onclick="action('dam38')"></span></td>
		
			<td><span id="dam39" onclick="action('dam39')"></span></td>
		
			<td><span id="dam40" onclick="action('dam40')"></span></td></tr>
			
			
			<tr><td><span id="dam41" onclick="action('dam41')"></span></td>
		
			<td><span id="dam42" onclick="action('dam42')"></span></td>
		
			<td><span id="dam43" onclick="action('dam43')"></span></td>
		
			<td><span id="dam44" onclick="action('dam44')"></span></td>
		
			<td><span id="dam45" onclick="action('dam45')"></span></td>
		
			<td><span id="dam46" onclick="action('dam46')"></span></td>
		
			<td><span id="dam47" onclick="action('dam47')"></span></td>
		
			<td><span id="dam48" onclick="action('dam48')"></span></td>
		
			<td><span id="dam49" onclick="action('dam49')"></span></td>
		
			<td><span id="dam50" onclick="action('dam50')"></span></td></tr>
			
			
			<tr><td><span id="dam51" onclick="action('dam51')"></span></td>
		
			<td><span id="dam52" onclick="action('dam52')"></span></td>
		
			<td><span id="dam53" onclick="action('dam53')"></span></td>
		
			<td><span id="dam54" onclick="action('dam54')"></span></td>
		
			<td><span id="dam55" onclick="action('dam55')"></span></td>
		
			<td><span id="dam56" onclick="action('dam56')"></span></td>
		
			<td><span id="dam57" onclick="action('dam57')"></span></td>
		
			<td><span id="dam58" onclick="action('dam58')"></span></td>
		
			<td><span id="dam59" onclick="action('dam59')"></span></td>
		
			<td><span id="dam60" onclick="action('dam60')"></span></td></tr>
			
			
			
			<tr><td><span id="dam61" onclick="action('dam61')"></span></td>
		
			<td><span id="dam62" onclick="action('dam62')"></span></td>
		
			<td><span id="dam63" onclick="action('dam63')"></span></td>
		
			<td><span id="dam64" onclick="action('dam64')"></span></td>
		
			<td><span id="dam65" onclick="action('dam65')"></span></td>
		
			<td><span id="dam66" onclick="action('dam66')"></span></td>
		
			<td><span id="dam67" onclick="action('dam67')"></span></td>
		
			<td><span id="dam68" onclick="action('dam68')"></span></td>
		
			<td><span id="dam69" onclick="action('dam69')"></span></td>
		
			<td><span id="dam70" onclick="action('dam70')"></span></td></tr>
			
			
			<tr><td><span id="dam71" onclick="action('dam71')"></span></td>
		
			<td><span id="dam72" onclick="action('dam72')"></span></td>
		
			<td><span id="dam73" onclick="action('dam73')"></span></td>
		
			<td><span id="dam74" onclick="action('dam74')"></span></td>
		
			<td><span id="dam75" onclick="action('dam75')"></span></td>
		
			<td><span id="dam76" onclick="action('dam76')"></span></td>
		
			<td><span id="dam77" onclick="action('dam77')"></span></td>
		
			<td><span id="dam78" onclick="action('dam78')"></span></td>
		
			<td><span id="dam79" onclick="action('dam79')"></span></td>
		
			<td><span id="dam80" onclick="action('dam80')"></span></td></tr>
			
			
			<tr><td><span id="dam81" onclick="action('dam81')"></span></td>
		
			<td><span id="dam82" onclick="action('dam82')"></span></td>
		
			<td><span id="dam83" onclick="action('dam83')"></span></td>
		
			<td><span id="dam84" onclick="action('dam84')"></span></td>
		
			<td><span id="dam85" onclick="action('dam85')"></span></td>
		
			<td><span id="dam86" onclick="action('dam86')"></span></td>
		
			<td><span id="dam87" onclick="action('dam87')"></span></td>
		
			<td><span id="dam88" onclick="action('dam88')"></span></td>
		
			<td><span id="dam89" onclick="action('dam89')"></span></td>
		
			<td><span id="dam90" onclick="action('dam90')"></span></td></tr>
			
			
			<tr><td><span id="dam91" onclick="action('dam91')"></span></td>
		
			<td><span id="dam92" onclick="action('dam92')"></span></td>
		
			<td><span id="dam93" onclick="action('dam93')"></span></td>
		
			<td><span id="dam94" onclick="action('dam94')"></span></td>
		
			<td><span id="dam95" onclick="action('dam95')"></span></td>
		
			<td><span id="dam96" onclick="action('dam96')"></span></td>
		
			<td><span id="dam97" onclick="action('dam97')"></span></td>
		
			<td><span id="dam98" onclick="action('dam98')"></span></td>
		
			<td><span id="dam99" onclick="action('dam99')"></span></td>
		
			<td><span id="dam100" onclick="action('dam100')"></span></td></tr>
		</table>
</div>
<script>
window.onload = function (){
var rouge = [1,3,5,7,9,12,14,16,18,20,21,23,25,27,29,32,34,36,38,40]; //rouge

var redRight = [];
var redLeft = [];

		var i =0;	
		while(i < rouge.length){
		document.getElementById("dam"+rouge[i]).style.backgroundColor="red";	
		i++;
		}
		
		
var vert = [61,63,65,67,69,72,74,76,78,80,81,83,85,87,89,92,94,96,98,100]; //vert

		var j =0;	
		while(j < vert.length){
		document.getElementById("dam"+vert[j]).style.backgroundColor="green";	
		j++;
		}
		
<!--var blanc = [2,4,6,8,10,11,13,15,17,19,22,24,26,28,30,31,33,35,37,39,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,62,64,66,68,70,71,73,75,77,79,82,84,86,88,90,91,93,95,97,99];-->

var blanc = [41,43,45,47,49,52,54,56,58,60];

		var k =0;	
		while(k < blanc.length){
		document.getElementById("dam"+blanc[k]).style.backgroundColor="white";	
		k++;
		}
		
				var changeColor=[2,4,6,8,10,11,13,15,17,19,22,24,26,28,30,31,33,35,37,39,42,44,46,48,50,51,53,55,57,59,62,64,66,68,70,71,73,75,77,79,82,84,86,88,90,91,93,95,97,99];
	/*	
		var d =0;	
		while(d < changeColor.length){
		document.getElementById("dam"+changeColor[d]).style.backgroundColor="black";	
		d++;
		}
	*/

}

function action(id){
	
	var tab = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,14,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100];
	
	// si le bouton cliqué est rouge ou vert alors passe au jaune

    if(document.getElementById(id).style.backgroundColor === "red")
       {
         document.getElementById(id).style.backgroundColor = "yellow";
		 
		sessionStorage.setItem("couleur","red");   //stocke l'utilisateur rouge
		
		sessionStorage.setItem("Tour","green");  // c'est au tour de l'utilisateur green de jouer
		
		
		
       }
	   
	   if(document.getElementById(id).style.backgroundColor === "green")
       {
         document.getElementById(id).style.backgroundColor = "yellow";
		 
		sessionStorage.setItem("couleur","green"); 
		
		sessionStorage.setItem("Tour","red"); // c'est au tour de l'utilisateur red de jouer
		
       }
	   


	// si un autre bouton cliqué est cliqué et qu'il est blanc alors il prend la couleur du précedent click
	if(document.getElementById(id).style.backgroundColor === "white"){
	

		for(var i =0; i < tab.length; i++){
			if(document.getElementById("dam"+tab[i]).style.backgroundColor == "yellow"){
			
			document.getElementById("dam"+tab[i]).style.backgroundColor="white";
			document.getElementById(id).style.backgroundColor = sessionStorage.getItem("couleur");

			for(var l =0; l < tab.length ; l++){
				
				if(id == "dam"+tab[l]){
				if(sessionStorage.getItem("Tour")=="green"){
				if(document.getElementById("dam"+(tab[l]-11)).style.backgroundColor != sessionStorage.getItem("couleur")){ 
				
				document.getElementById("dam"+(tab[l]-11)).style.backgroundColor = "white";
				
				if((tab[l]-11)==10 || (tab[l]-11)==30 || (tab[l]-11)==50 || (tab[l]-11)==70){
				document.getElementById("dam"+(tab[l]-11)).style.backgroundColor = "black";	
				}
				
				}
				
				if(document.getElementById("dam"+(tab[l]-9)).style.backgroundColor !=sessionStorage.getItem("couleur") ){ 
				
				document.getElementById("dam"+(tab[l]-9)).style.backgroundColor = "white";
								
				if((tab[l]-9)==11 || (tab[l]-9)==71 || (tab[l]-9)==91 || (tab[l]-9)==51 || (tab[l]-9)==31){
				document.getElementById("dam"+(tab[l]-9)).style.backgroundColor = "black";	
				}
				
				}
				}
				
				if(sessionStorage.getItem("Tour")=="red"){
				if(document.getElementById("dam"+(tab[l]+11)).style.backgroundColor != sessionStorage.getItem("couleur")){ 
				
				document.getElementById("dam"+(tab[l]+11)).style.backgroundColor = "white";
				
				if((tab[l]+11)==71 || (tab[l]+11)==51 || (tab[l]+11)==31 || (tab[l]+11)==91){
				document.getElementById("dam"+(tab[l]+11)).style.backgroundColor = "black";	
				}
				
				}
				
				if(document.getElementById("dam"+(tab[l]+9)).style.backgroundColor !=sessionStorage.getItem("couleur") ){ 
				document.getElementById("dam"+(tab[l]+9)).style.backgroundColor = "white";
				
				if((tab[l]+9)==30 || (tab[l]+9)==50 || (tab[l]+9)==70 || (tab[l]+9)==90 || (tab[l]+9)==10 ){
				document.getElementById("dam"+(tab[l]+9)).style.backgroundColor = "black";	
				}
				
				}
				}
					
				}
				
			}
			
			}
		}
	}
	
	//Green Wins
		var GreenWin=[1,3,5,7,9];
		
		for(var d =0; d < GreenWin.length; d++){
		if(document.getElementById("dam"+GreenWin[d]).style.backgroundColor == "green"){
		document.getElementById("resultat").innerHTML ="Green chips win the game!!!";	
		}
		}
	
	//Red Wins
		var RedWin=[92,94,96,98,100];
		
		for(var d =0; d < RedWin.length; d++){
		if(document.getElementById("dam"+RedWin[d]).style.backgroundColor == "red"){
		document.getElementById("resultat").innerHTML ="Red chips win the game!!!";	
		}
		}
		
	//Nombre de pieces restantes
	var redRest = 0;
	var greenRest = 0;
	var redscore = 0;
	var greenscore = 0;
		for(var d =0; d < tab.length; d++){
		if(document.getElementById("dam"+tab[d]).style.backgroundColor == "red"){
		redRest++;		
		}
		else if(document.getElementById("dam"+tab[d]).style.backgroundColor == "green"){
		greenRest++;	
		}
		}
		
		redscore = (20 - greenRest);
		greenscore = (20 - redRest);
		
		
		document.getElementById("redscore").innerHTML = redscore+" Points!";	
		document.getElementById("greenscore").innerHTML = greenscore+" Points!";
		
		if(redRest ==0){
		document.getElementById("resultat").innerHTML ="Green chips win the game!!!";	
		}
		
		if(greenRest==0){
		document.getElementById("resultat").innerHTML ="Red chips win the game!!!";	
		}
}

function charger(){
	window.location.href="index.jsp";
}
</script>
<center><input type="button" value="Restart Game" onclick="charger()"/></center>
<body>

</body>

</html>
