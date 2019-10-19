#ifndef CPLAYER_H
#define CPLAYER_H

class CPlayer {

private:
	CShip m_ships[];
	string m_name;
	int m_money;
	CShip attribute[];

public:
	void PrintShips();
};

#endif
