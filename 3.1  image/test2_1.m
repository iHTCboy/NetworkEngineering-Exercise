I = imread('lenna.bmp');
J = translate(I,200,200);
imshow(I);
title('Դͼ��');
figure;
imshow(J);
title('translated');