#ifndef CSHIP_H
#define CSHIP_H

class CShip {

private:
	int m_maxHealth;
	int m_actualHealth;
	TSpeed m_speed;
	int m_attackDamage;
	int m_level;
	int m_range;
	CItem* m_item;

public:
	void PrintShipStatus();
	virtual CAttackOutput Attack(CShip* TargetedShip) = 0;
};

#endif
