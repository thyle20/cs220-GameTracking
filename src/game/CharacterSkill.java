package game;

public enum CharacterSkill {
	AfterLife, //Survive 1 time. 1 time skill
	SuperBody, //Does not lose blood when being attack. 2 times
	Amenotejikara, //constantly switch the place. Have to guess. The x,y position is random between 1 and 10. For hard level
	Amaterasu, //Player lose 20% blood. Activate skill when character's blood =40 (1 time)
	Assimilation //Player lose 30% blood. Activate skill when character's blood = 80, 60 ( 2times)
}
