import {InstagramOutlined, XOutlined, YoutubeOutlined} from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import React from 'react';

const Footer: React.FC = () => {
  const defaultMessage = '大香蕉'
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      style={{
        background: 'none',
      }}
      links={[
        {
          key: 'Ins',
          title: <InstagramOutlined/>,
          href: 'https://instagram.com',
          blankTarget: true,
        },
        {
          key: 'X',
          title: <XOutlined/>,
          href: 'https://x.com',
          blankTarget: true,
        },
        {
          key: 'Youtube',
          title: < YoutubeOutlined/>,
          href: 'https://youtube.com',
          blankTarget: true,
        },

      ]}
    />
  );
};

export default Footer;
