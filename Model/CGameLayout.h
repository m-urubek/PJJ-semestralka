#ifndef CGAMELAYOUT_H
#define CGAMELAYOUT_H

class CGameLayout {

private:
	CField m_content[][];

public:
	void DeleteFieldContent(CField Field);
	void DeleteFieldContent(int X, char Y);
	void ChangeField();
	CField& operator[](int Index);
	CField& operator[](int Index);
	CField& operator[](int Index);
};

#endif
