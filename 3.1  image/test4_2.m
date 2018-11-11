I = imread('G:\D��HTC\image\cameraman.tif');
subplot(3,3,1)
imshow(I);
title('Original Image'); 

J = imnoise(I,'gaussian',0,0.005);
subplot(3,3,2)
imshow(J);
title('��˹����'); 

K = imnoise(I,'salt & pepper',0.02);
subplot(3,3,3)
imshow(K);
title('��������'); 


H = fspecial('average',[3 3]);
filter2(H);
subplot(3,3,4);
title('��˹-��ֵ�˲�1');


M2 = imfilter(K,H);
U2 = filter2([3 5;3 5],M2);
subplot(3,3,5);
imshow(U2);
title('����-��ֵ�˲�2');

A = medfilt2(J);
subplot(3,3,6);
imshow(A);
title('��˹-��ֵ�˲�1');

B = medfilt2(K);
subplot(3,3,7);
imshow(B);
title('����-��ֵ�˲�2');


