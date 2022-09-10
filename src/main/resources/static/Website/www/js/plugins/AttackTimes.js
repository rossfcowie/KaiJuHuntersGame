//=============================================================================
// AttackTimes.js
//=============================================================================
 
/*:
 * @plugindesc All skills are treated as basic attacks by the game
 * @author by Alevel3mage
 *
 *
 * @help All skills are treated as basic attacks causing them to have an attack swing
 * Benefit from the "attacktimes" effect and any other effects I forgot about.
 *
*/
 
(function(){
Game_Action.prototype.isAttack = function() {
    return (this._item.isSkill())?true:false;
};
})();



(function(){
Game_Action.prototype.numRepeats = function() {
    var repeats = this.item().repeats;
    if (this.isAttack()) {
		var noTimes = this.item().meta.times || 1;
        repeats = repeats + noTimes * (1 * this.subject().attackTimesAdd());
    }
    return Math.floor(repeats);
};
})();