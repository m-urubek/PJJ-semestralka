#ifndef CNAMEHOLDER_H
#define CNAMEHOLDER_H

class CNameHolder {

private:
	CPlayer m_playerOne;
	CPlayer m_playerTwo;
	int m_roundNumber;
	CGameLayout m_gameLayout;

public:
	void Start(string PlayerOneName, string PlayerTwoName);

	void Start();

	void End();

private:
	void m_move();
};

#endif
