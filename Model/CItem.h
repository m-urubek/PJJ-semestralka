#ifndef CITEM_H
#define CITEM_H

class CItem {

private:
	TPercentage m_health;
	TPercentage m_attackDamage;
	TRangeUpgrade m_range;
	string m_name;

public:
	CItem();
};

#endif
