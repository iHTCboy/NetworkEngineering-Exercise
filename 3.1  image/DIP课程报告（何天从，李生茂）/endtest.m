% ��ȡͼ��
I =imread('����ʵ��ͼ��.gif');           
subplot(2,4,1);                   
imshow(I);                                  
title('Դͼ��');                  

%ֱ��ͼ���⻯����
subplot(2,4,2);
imhist(I);
title('���⻯ǰֱ��ͼ');
J =histeq(I);
subplot(2,4,3),
imshow(J);
title('���⻯��ͼ��');
subplot(2,4,4),
imhist(J);
title('���⻯��ֱ��ͼ');



%�Ҷȵ���
K = imadjust(J,[0.7 0.9],[]);
subplot(2,4,5),
imshow(K);
title('ԭͼ���任�ĻҶȷ�ΧΪ(0.7 0.9)');




%ƽ�����񻯴���
K =double(K);
P =wiener2(K); %��άά���˲�wiener2 
subplot(2,4,6),
imshow(P,[]);
title('����Ӧ�˲�ƽ��������ͼ��');




%��Ե��⴦��
M =edge(I, 'canny', [0.1 0.35]);   %��canny�����ҳ���Ե
subplot(2,4,7)       
imshow(M);                                  
title('��canny���Ӵ����ͼ��')           




%ͼ�����
M1 = 800*M;  %��Ե��ǿ
N =imlincomb(0.3,M1,0.7,P); %0.3��0.7����Ϊ����ͼ����Ȩֵ
subplot(2,4,8) ;
imshow(N ,[]);
title('���յ�ͼ��');
