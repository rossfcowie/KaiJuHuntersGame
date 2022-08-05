//=============================================================================
// Colors.js
//=============================================================================
 
/*:
 * @plugindesc Allows you to assign items and equipment colors. Modified by alevel3mage to allow class colours aswell
 * @author kranasAngel modified by Alevel3mage
 *
 *
 * @help Changes the Item's color based on the notetag  
 * <itemColor:x> 
 * Changes the Class' color based on the notetag  
 * <color:x> 
 * Where x is the color code that you want. 
 * To find Rpg maker color codes, search rpg maker color codes, or something similar.
 *
 *   
 * 
 *
 *
 *
*/


(function(){
 
Window_Base.prototype.drawItemName = function(item, x, y, width) {width = width || 312; if (item) {
	var iconBoxWidth = Window_Base._iconWidth + 4;
	this.resetTextColor();
	this.drawIcon(item.iconIndex, x + 2, y + 2);
	if (typeof item.meta.color !== "undefined"){
		var element = parseInt(item.meta.color);
		this.changeTextColor(this.textColor(element)) 
		console.log("item Color" + element);
		};
	this.drawText(item.name, x + iconBoxWidth, y, width - iconBoxWidth);
	this.resetTextColor();
	};
	};
})();

(function(){

Window_Base.prototype.drawActorClass = function(actor, x, y, width) {
width = width || 168;
this.resetTextColor();
if(actor.currentClass().meta.color !== "undefined"){
var element = parseInt(actor.currentClass().meta.color) || 0 ;
console.log("Class Color" + element);}
this.changeTextColor(this.textColor(element));
this.drawText(actor.currentClass().name +" | "+ actor.nickname(), x, y, width);
this.resetTextColor();
};
})();
