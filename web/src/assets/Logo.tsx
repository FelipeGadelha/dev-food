import React from 'react';

type Props = {
  fill: string
}

const Logo: React.FC<Props> = ({fill}) => {
  return (
    <svg width="42" height="27" viewBox="0 0 42 27" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M35.6689 25.5363C33.3755 25.4831 31.5596 23.5908 31.613 21.3098C31.6665 19.0287 33.569 17.2227 35.8625 17.2758C38.1559 17.329 39.9718 19.2212 39.9184 21.5023C39.8649 23.7833 37.9624 25.5894 35.6689 25.5363Z" stroke={fill} strokeWidth="2" strokeMiterlimit="10"/>
      <path d="M9.03176 25.5366C6.73769 25.5366 4.87798 23.6869 4.87798 21.4053C4.87798 19.1236 6.73769 17.2739 9.03176 17.2739C11.3258 17.2739 13.1855 19.1236 13.1855 21.4053C13.1855 23.6869 11.3258 25.5366 9.03176 25.5366Z" stroke={fill} strokeWidth="2" strokeMiterlimit="10"/>
      <path d="M28.0987 21.3169C28.101 20.3375 28.2977 19.3681 28.6776 18.4645C29.0574 17.5608 29.6129 16.7406 30.3121 16.0509C33.2629 13.1282 38.0493 13.1282 41 16.0509" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M1.21971 21.3169C1.21971 17.1825 4.58915 13.832 8.74597 13.832C12.9028 13.832 16.2715 17.1833 16.2715 21.3176" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M17.3472 5.27783H3.37025V9.55553H17.3472V5.27783Z" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M36.6997 13.8323L30.2483 1H25.9474" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M28.0986 21.4058H16.2714" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M17.3472 9.55469C17.3472 9.55469 21.6482 25.5949 30.2485 9.55469" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M3.37012 9.55469C3.37012 9.55469 0.144033 14.9014 1.21965 21.3172" stroke={fill} strokeWidth="2" strokeMiterlimit="10" strokeLinecap="round" strokeLinejoin="round"/>
    </svg>
  );
}

export default Logo;